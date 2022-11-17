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
  getHello(): string {
    return 'Hello World!';
  }

  goBar(): void {
    console.log(fflip.getFeaturesForUser(Users[0]));
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

  getUs() {
    return this.ListUs;
  }
}
