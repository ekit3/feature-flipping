import { Controller, Get, Param, Post } from '@nestjs/common';
import { AppService } from './app.service';
import { Users, Features } from "./features";

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get('/goBar')
  getGoBar() {
    return this.appService.goBar();
  }

  @Get('/goBar/:userName')
  getGoBarForUser(@Param('userName') userName) {
    return this.appService.goBarForUser(userName);
  }

  @Get('/users/features/:userName')
  getUserFeatures(@Param('userName') userName) {
    return this.appService.getUserFeatures(userName);
  }

  @Get('features')
  getFeatures() {
    return this.appService.getFeatures();
  }

  @Post('features/activate/:featureName/:userName')
  activateFeature(@Param('featureName') featureName, @Param('userName') userName){
    return this.appService.activateFeature(featureName, userName);
  }

  @Post('features/desactivate/:featureName/:userName')
  desactivateFeature(@Param('featureName') featureName, @Param('userName') userName){
    return this.appService.desactivateFeature(featureName, userName);
  }

  @Get('/users')
  getUsers() {
    return this.appService.getUsers();
  }
}
