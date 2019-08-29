import { TestBed } from '@angular/core/testing';

import { ProjectTaskDataService } from './project-task-data.service';

describe('ProjectTaskDataService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ProjectTaskDataService = TestBed.get(ProjectTaskDataService);
    expect(service).toBeTruthy();
  });
});
