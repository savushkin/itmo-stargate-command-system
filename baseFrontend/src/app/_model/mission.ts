import {Zone} from "@sgc/_model/zone";
import {Command} from "@sgc/_model/command";

export interface Mission {
  id: number;
  description: string;
  date: number;
  zone: Zone;
  command: Command;
}
