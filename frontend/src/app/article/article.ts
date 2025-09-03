import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { environment } from '../../environments/environment';
import axios from 'axios';

@Component({
  selector: 'app-article',
  imports: [],
  templateUrl: './article.html'
})
export class Article {
  id: string | null = null;

  message: string | null = null;

  constructor(private route: ActivatedRoute) {
    this.route.paramMap.subscribe(async params => {
      this.id = params.get('id');

      const apiUrl = environment.apiUrl;
      console.log(apiUrl)
      const response = await axios.get(`${apiUrl}`)
      this.message = response.data;
    });
  }
}
