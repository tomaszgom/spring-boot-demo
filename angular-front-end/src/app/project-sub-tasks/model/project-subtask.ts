export interface ProjectSubTask {

	id: number;
    // @ManyToOne
	// private TeamMember teamMember;
    title: string;
    description: string;
    status: string;
    priority: string;
    deadLineDate: Date;
    projectTask: number;

}
