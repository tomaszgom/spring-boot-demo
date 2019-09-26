export interface ProjectTask {

	id: number;
    // @ManyToOne
	// private TeamMember teamMember;
    title: string;
    description: string;
    status: string;
    priority: string;
    deadLineDate: Date;
    teamMember: number;
}
