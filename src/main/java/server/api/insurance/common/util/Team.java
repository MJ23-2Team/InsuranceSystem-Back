package server.api.insurance.common.util;

import lombok.Getter;
import lombok.Setter;
import server.api.insurance.employee.entity.Insurance;

@Getter
@Setter
public abstract class Team {
	private int teamID;
	private String teamName;
	public Insurance m_Insurance;

	public Team(){}

	public abstract void establishPolicy(Object request);
	public abstract void manage(Constants.Target target, Constants.Crud crud );
	public abstract void plan(Constants.Target target, Constants.Crud crud );
	public abstract void process(Constants.Target target, Constants.Crud crud );
}