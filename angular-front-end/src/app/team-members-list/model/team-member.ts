export interface TeamMember {

	id : number;
    // @ManyToOne
    // private TeamMember teamMember;
    firstName : string;
    lastName : string; 
    emailAddress : string;
    position : string;
    points : number;
    phone : string;
    note : string;

}
