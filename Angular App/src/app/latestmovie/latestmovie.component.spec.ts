import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LatestmovieComponent } from './latestmovie.component';

describe('LatestmovieComponent', () => {
  let component: LatestmovieComponent;
  let fixture: ComponentFixture<LatestmovieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LatestmovieComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LatestmovieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
