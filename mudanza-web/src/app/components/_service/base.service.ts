import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { SettingService } from "./setting.service";

@Injectable()
export abstract class BaseService {
    public urlHost: string = '';
    private endPoint = '';
    private settingService: SettingService = new SettingService();

    constructor(public http: HttpClient) {
        this.urlHost = this.settingService.obtenerUrlHost();
    }

    get EndPoint(): string {
        return this.endPoint;
    }

    set EndPoint(endPoint: string) {
        this.endPoint = endPoint;
    }

    public doPost(data: any): Promise<any> {
        return this.http.post(this.urlHost + this.EndPoint, data).toPromise()
            .then(res => res)
            .catch(res => {
                console.log('Error ::',res)
                throw new Error("Error system");
            });
    }
}