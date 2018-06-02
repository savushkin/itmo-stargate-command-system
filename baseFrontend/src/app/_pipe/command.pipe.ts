import {Pipe, PipeTransform} from '@angular/core';
import {CommandService} from "@sgc/_service/command/command.service";

@Pipe({
  name: 'command'
})
export class CommandPipe implements PipeTransform {

  constructor(private commandService: CommandService) {

  }

  transform(id: any, args?: any): any {
    let commands = this.commandService.commands.getValue();
    for (let i = 0, len = commands.length; i < len; i++) {
      if (commands[i]['id'] === id) {
        return commands[i]['name'];
      }
    }
    return '';
  }

}
