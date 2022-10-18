let Users = [{
  id: 1,
  name: 'Bob',
  isPaid: false,
  role: 'scrum',
  canDrinkBeer: false
},{
  id: 2,
  name: 'Martine',
  isPaid: true,
  role: 'po',
  canDrinkBeer: true
}]

let AllowEdIds = [2]

let Criteria = [
  {
    id: 'isPaidUser',
    check: function(user, isPaid) {
      return user.isPaid == isPaid;
    }
  },
  {
    id: 'percentageOfUsers',
    check: function(user, percent) {
      return (user.id % 100 < percent * 100);
    }
  },
  {
    id: 'allowUserIDs',
    check: function(user, allowedIDs) {
      return allowedIDs.indexOf(user.id) > -1;
    }
  },
  {
    id: 'canDrinkBeer',
    check: function(user, canDrinkBeer) {
      return user.canDrinkBeer === canDrinkBeer
    }
  }
];

let Features = [
  {
    id: 'closedBeta', // required
    // if `criteria` is in an object, ALL criteria in that set must evaluate to true to enable for user
    criteria: {isPaidUser: true, percentageOfUsers: 0.50}
  },
  {
    id: 'canDrinkBeer',
    criteria: { canDrinkBeer: true }
  },
  {
    id: 'newFeatureRollout',
    // if `criteria` is in an array, ANY ONE set of criteria must evaluate to true to enable for user
    criteria: [{isPaidUser: true}, {percentageOfUsers: 0.50}, {allowUserIDs: AllowEdIds}]
  },
  {
    id: 'experimentalFeature',
    name: 'An Experimental Feature', // user-defined properties are optional but can be used to add important metadata on both criteria & features
    description: 'Experimental feature still in development, useful for internal development', // user-defined
    owner: 'Fred K. Schott <fkschott@gmail.com>', // user-defined
    enabled: false, // sets the feature on or off for all users, required if `criteria` is not present
  },

];


let fflip = require('fflip');

fflip.config({
  criteria: Criteria, // defined below
  features: Features  // defined below
});

export { fflip,Users,AllowEdIds, Features };
