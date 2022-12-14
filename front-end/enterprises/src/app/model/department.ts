import { Enterprise } from "./enterprise";

export interface Department {
    id:number;
    created_by:String;
    created_date:Date;
    modified_by:String;
    modified_date:Date;
    status:Boolean;
    description:String;
    name:String;
    phone:String;
    id_enterprise:Enterprise;
}