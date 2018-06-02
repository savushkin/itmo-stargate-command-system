import {User} from "@sgc/_model/user";

export interface Command {
  id: number;
  name: any;
  commandType: any;
  description: any;
  members: User[];
}
