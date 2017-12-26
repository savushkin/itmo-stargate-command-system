import {User} from "@sgc/_model/user";

export interface Command {
  id: number;
  commandType: any;
  members: User[];
}
