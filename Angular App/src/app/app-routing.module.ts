import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoryComponent } from './category/category.component';
import { FavouriteComponent } from './favourite/favourite.component';

import { LatestmovieComponent } from './latestmovie/latestmovie.component';
import { LoginComponent } from './login/login.component';
import { LoginGuard } from './login/login.guard';
import { MovieComponent } from './movie/movie.component';
import { PlayComponent } from './movie/play/play.component';
import { SelectedComponent } from './movie/selected/selected.component';


import { RegisterComponent } from './register/register.component';
import { SearchComponent } from './search/search.component';
import { UserprofileComponent } from './userprofile/userprofile.component';

const routes: Routes = [
  { path:'', component: MovieComponent  },

  { path:'movie', component: MovieComponent },
  { path:'login', component: LoginComponent },
  { path:'register', component: RegisterComponent },
  { path:'userprofile',canActivate:[LoginGuard], component: UserprofileComponent },
  { path:'movie', component:MovieComponent },
  {path:'favourite',canActivate:[LoginGuard],component:FavouriteComponent},
  {path:'selected',component:SelectedComponent},
  {path:'category',component:CategoryComponent},
  {path:'search',component:SearchComponent},
  {path:'latestmovie',component:LatestmovieComponent},
  { path: 'play', component: PlayComponent }

  // { path:'**', component: InvalidComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
