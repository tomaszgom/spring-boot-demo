import { TestBed } from '@angular/core/testing';

import { TeamMemberDataService } from './team-member-data.service';

describe('TeamMemberDataService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TeamMemberDataService = TestBed.get(TeamMemberDataService);
    expect(service).toBeTruthy();
  });
});
