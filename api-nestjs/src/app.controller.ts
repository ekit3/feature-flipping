import { Controller, Get, Param } from '@nestjs/common';
import { AppService } from './app.service';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get('/goBar')
  getGoBar() {
    return this.appService.goBar();
  }

  @Get('/users/features/:userName')
  getUserFeatures(@Param('userName') userName) {
    return this.appService.getUserFeatures(userName);
  }

  @Get('features')
  getFeatures() {
    return this.appService.getFeatures();
  }

  @Get('/users')
  getUsers() {
    return this.appService.getUsers();
  }
}
