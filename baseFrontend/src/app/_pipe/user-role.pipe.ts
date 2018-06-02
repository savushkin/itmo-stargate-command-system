import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'userRole'
})
export class UserRolePipe implements PipeTransform {

  transform(value: any, args?: any): any {
    switch (value) {
      case 'ROLE_SCOUT':
        return 'Разведчик';
      case 'ROLE_DIPLOMAT':
        return 'Дипломат';
      case 'ROLE_DRONE':
        return 'Дрон';
      case 'ROLE_USER':
        return 'Пользователь';
      case 'ROLE_ARCHAEOLOGIST':
        return 'Археолог';
      case 'ROLE_GEOLOGIST':
        return 'Геолог';
      case 'ROLE_COMMANDER':
        return 'Командующий';
      case 'ROLE_SG':
        return 'Член отряда';
      case 'ROLE_OPERATOR':
        return 'Оператор';
      case 'ROLE_ADMINISTRATOR':
        return 'Администратор';
      default:
        return value;
    }
  }

}
