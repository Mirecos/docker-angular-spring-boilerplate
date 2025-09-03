import { Routes } from '@angular/router';
import { Edit } from './edit/edit';
import { Article } from './article/article';

export const routes: Routes = [
	{ path: 'edit/:id', component: Edit },
	{ path: 'article/:id', component: Article }
];
