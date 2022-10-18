import { Controller, Get } from '@nestjs/common';
import { AppService } from './app.service';

@Controller()
export class AppController {
  constructor(private readonly appService: AppService) {}

  @Get('/goBar')
  getGoBar() {
    return this.appService.goBar();
  }

  @Get('/users/features')
  getUserFeatures() {
    return this.appService.getUserFeatures();
  }

  @Get('features')
  getFeatures() {
    return this.appService.getFeatures();
  }

  @Get('/users')
  getUsers(){
    return this.appService.getUsers();
  }
}
