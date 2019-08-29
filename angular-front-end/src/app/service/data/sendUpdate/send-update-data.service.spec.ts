import { TestBed } from '@angular/core/testing';

import { SendUpdateDataService } from './send-update-data.service';

describe('SendUpdateDataService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SendUpdateDataService = TestBed.get(SendUpdateDataService);
    expect(service).toBeTruthy();
  });
});
