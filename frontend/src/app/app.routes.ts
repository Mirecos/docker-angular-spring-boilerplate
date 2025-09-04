import { Routes } from '@angular/router';
import { Edit } from './pages/edit/edit';
import { Article } from './pages/article/article';
import { Login } from './pages/login/login';
import { authGuard } from './auth/auth.guard';

export const routes: Routes = [
	{ path: 'edit/:id', component: Edit, canActivate: [authGuard] },
	{ path: 'article/:id', component: Article, canActivate: [authGuard] },
	{ path: 'login', component: Login }
];
