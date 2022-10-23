import { useParams } from 'react-router-dom';
import React, { useCallback, useEffect, useState } from 'react';
import { getUserFeature } from './services/UserService';
import { Flags } from 'react-feature-flags';
import { FlagsProvider } from 'react-feature-flags';
import { Chip, Divider } from '@mui/material';

const UserDetails = () => {
  const { userName } = useParams();
  const fetchUserFeatures = useCallback(async () => {
    const response = await getUserFeature(userName as string);
    const allowedFeatures: any[] = [];
    for (const [key, value] of Object.entries(response)) {
      if (value) {
        allowedFeatures.push({ name: key.toString(), isActive: true });
      }
    }

    setUserFeatures(allowedFeatures);
  }, [userName]);

  const [userFeatures, setUserFeatures] = useState<any[]>([]);

  useEffect(() => {
    fetchUserFeatures().catch((e) => console.log(e));
  }, [fetchUserFeatures]);

  return (
    <>
      <FlagsProvider value={userFeatures}>
        <Divider>
          <Chip label="User Details " />
        </Divider>
        user details : {userName}
        <Divider>
          <Chip label="Features switch" />
        </Divider>
        <Flags
          authorizedFlags={['us']}
          renderOn={() => <h1>{userName} can see us</h1>}
          renderOff={() => <h1>{userName} can't see us</h1>}
        />
      </FlagsProvider>
    </>
  );
};

export default UserDetails;
