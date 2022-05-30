import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';

import { LoginComponent } from './login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MovieComponent } from './movie/movie.component';
import { HttpClientModule } from '@angular/common/http';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { LayoutModule } from '@angular/cdk/layout';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatListModule } from '@angular/material/list';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatTooltipModule } from '@angular/material/tooltip';
import {MatAutocompleteModule} from '@angular/material/autocomplete';



import {MatMenuModule} from '@angular/material/menu';

import { NgbCarouselModule, NgbRatingModule } from '@ng-bootstrap/ng-bootstrap';
import { NavigationbarComponent } from './navigationbar/navigationbar.component';
import { CategoryComponent } from './category/category.component';
import { SelectedComponent } from './movie/selected/selected.component';
import { FavouriteComponent } from './favourite/favourite.component';
import { UserprofileComponent } from './userprofile/userprofile.component';
import { CheckDirective } from './services/check.directive';
import { SearchComponent } from './search/search.component';
import { LatestmovieComponent } from './latestmovie/latestmovie.component';
import { MatDialogModule} from '@angular/material/dialog';
import { PlayComponent } from './movie/play/play.component';
@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,

    LoginComponent,
    MovieComponent,
    FavouriteComponent,

    NavigationbarComponent,
    CategoryComponent,
    SelectedComponent,
    UserprofileComponent,
    CheckDirective,
    SearchComponent,
    LatestmovieComponent,
  
    PlayComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatCardModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatInputModule,
    MatTableModule,
    MatTooltipModule,
    MatMenuModule,
    NgbCarouselModule,
    NgbRatingModule,
    FormsModule,
    MatAutocompleteModule,
    MatDialogModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class AppModule { }
