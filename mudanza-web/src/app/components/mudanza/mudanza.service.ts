import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BaseService } from '../_service/base.service';
import { saveAs } from 'file-saver';

@Injectable({providedIn: 'root'})
export class MudanzaService extends BaseService{

    constructor(public http: HttpClient){
        super(http)
    }

    uploadFile(file: FormData, document: String): Promise<any> {
        this.EndPoint = '/upload/' + document;
        return super.doPost(file);
    }

    downLoadFile(data: any, type: string) {
        var blob = new Blob([data], { type: type.toString() });
        var url = window.URL.createObjectURL(blob);
        saveAs(blob,"Salida.txt");
    }

}