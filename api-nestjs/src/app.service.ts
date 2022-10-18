import { Injectable, Scope, Inject } from '@nestjs/common';
import { fflip, Users, AllowEdIds, Features} from "./features";
import { REQUEST } from '@nestjs/core';
import { Request } from 'express';
@Injectable({ scope: Scope.REQUEST })
export class AppService {
  constructor(@Inject(REQUEST) private request: Request) {}
  getHello(): string {
    return 'Hello World!';
  }

  goBar(): void {
    console.log(this.request)
    console.log(fflip.getFeaturesForUser(Users[0]));
  }

  getUserFeatures(): void {
    return fflip.getFeaturesForUser(Users[0]);
  }

  getFeatures() {
    return Features;
  }

  getUsers() {
    return Users;
  }
}
