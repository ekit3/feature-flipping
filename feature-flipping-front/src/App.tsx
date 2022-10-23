import React, { useCallback, useEffect, useState } from 'react';
import { getFeatures } from './services/UserService';
import { Chip, Divider, List, ListItem, ListItemText } from '@mui/material';
import { RouterProvider } from 'react-router-dom';
import { router } from './router';

const App = () => {
  const fetchFeatures = useCallback(async () => {
    const feats = await getFeatures();
    setFeatures(feats);
  }, []);

  const [features, setFeatures] = useState<any[]>([]);

  useEffect(() => {
    fetchFeatures().catch((e) => console.log(e));
  }, [fetchFeatures]);

  return (
    <>
      <RouterProvider router={router} />

      <Divider>
        <Chip label="Available features" />
      </Divider>

      <List dense={true}>
        {features.map((feature, index) => {
          return (
            <ListItem key={index}>
              <ListItemText
                primary={feature.id}
                secondary={JSON.stringify(feature.criteria)}
              />
            </ListItem>
          );
        })}
      </List>
    </>
  );
};

export default App;
