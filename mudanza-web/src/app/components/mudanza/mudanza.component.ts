import { Component, OnInit } from '@angular/core';
import { MudanzaService } from './mudanza.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-mudanza',
  templateUrl: './mudanza.component.html',
  styleUrls: ['./mudanza.component.css']
})
export class MudanzaComponent implements OnInit {

  private uploadedFiles: File;
  public mundanzaForm: FormGroup;
  public alert: boolean;
  public message: String;

  constructor(private formBilder: FormBuilder,
    private service: MudanzaService) { }

  ngOnInit() {
    this.mundanzaForm = this.formBilder.group({
      file: ['', Validators.required],
      document: ['', Validators.required]
    });
    this.alert = false;
  }

  onFileChange(event) {
    this.uploadedFiles = event.target.files;
    console.log('file ', this.uploadedFiles)
  }

  onUpload() {
    if (this.mundanzaForm.value.document !== '' && this.mundanzaForm.value.file !== '') {
      const formData = new FormData();
      formData.append('file', this.uploadedFiles[0], this.uploadedFiles.name);
      this.service.uploadFile(formData, this.mundanzaForm.value.document)
      .then((res) => {
        console.log('Response: ', res);
        this.service.downLoadFile(res, "text/plain");})
      .catch(res => {
        this.message = "Error realizando la operacion"
        this.alert = true;
        });
      this.alert = false;
    } else {
      this.message = "Debe diligenciar los campos";
      this.alert = true;
    }

  }

}
