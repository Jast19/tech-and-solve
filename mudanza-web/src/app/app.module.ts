import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { MudanzaService } from './components/mudanza/mudanza.service';
import { MudanzaComponent } from './components/mudanza/mudanza.component';

@NgModule({
  declarations: [
    AppComponent,
    MudanzaComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [MudanzaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
