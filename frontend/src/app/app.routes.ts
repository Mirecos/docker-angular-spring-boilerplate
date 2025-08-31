import { Routes } from '@angular/router';
import { Welcome } from './pages/welcome/welcome';
import { Home } from './pages/home/home';

export const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/welcome' },
  { path: 'welcome', component: Welcome },
  { path: 'home', component: Home }
];
