import { IWorldOptions , setWorldConstructor, World } from '@cucumber/cucumber';
import { PageManager } from '../page-objects/pageManager';

class CustomWorld extends World {
  selectedChair: string | null = null;
  selectedChairs: string[] = [];
  pageManager: PageManager;

  constructor(options: IWorldOptions){
    super(options);
  }
}

setWorldConstructor(CustomWorld);