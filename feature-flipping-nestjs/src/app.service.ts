import { Injectable, Scope, Inject } from '@nestjs/common';
import { fflip, Users, AllowEdIds, Features } from './features';
import { REQUEST } from '@nestjs/core';
import { Request } from 'express';
@Injectable({ scope: Scope.REQUEST })
export class AppService {
  private ListUs = [
    {
      id: 1,
      name: 'US-1',
      content: 'My us-1 content',
    },
    {
      id: 2,
      name: 'US-2',
      content: 'My us-2 content',
    },
  ];

  constructor(@Inject(REQUEST) private request: Request) {}

  goBar(): String {
    console.log(fflip.getFeaturesForUser(Users[0]));
    let listName = []
    let str = ''
    Users.forEach( user => {
      if (fflip.isFeatureEnabledForUser('canDrinkBeer', user) === true) {
        console.log('Welcome to the Closed Beta!');
        listName.push(user.name)
        str += `${user.name} can go drink some beer ! \n`
      }
    })
    return str;

  }

  goBarForUser(userName: string): String {
    let user = Users.find((user) => user.name === userName)
    console.log(userName)
    if (fflip.isFeatureEnabledForUser('canDrinkBeer', user) === true) {
      return `${userName} can go drink some beer ! \n`
    } else {
      return `No beer for you ${userName} ! \n`
    }
  }

  getUserFeatures(userName: string): void {
    return fflip.getFeaturesForUser(
      Users.find((user) => user.name === userName),
    );
  }

  getFeatures() {
    return Features;
  }

  getUsers() {
    return Users;
  }

  activateFeature(featureName: string, userName: string): string {
    let user = Users.find( user => user.name === userName)
    if (user !== undefined) {
      Features.forEach( feat => {
        switch (feat.id) {
          case 'canDrinkBeer':
            user.canDrinkBeer = true;
            return "Change Success"
        default:
          return "This feature cannot be activate by api call"
        }
      })
    } else {
      return "User do not exist"
    }
  }

  desactivateFeature(featureName: string, userName: string): string {
    let user = Users.find( user => user.name === userName)
    if (user !== undefined) {
      Features.forEach( feat => {
        switch (feat.id) {
          case 'canDrinkBeer':
            user.canDrinkBeer = false;
            return "Change Success"
        default:
          return "This feature cannot be activate by api call"
        }
      })
    } else {
      return "User do not exist"
    }
  }

  getUs() {
    return this.ListUs;
  }
}
