package controller;

import controller.action.Action;
import controller.action.IdCheckAction;
import controller.action.IndexAction;
import controller.action.JoinAction;

/*
 * 페이지 컨트롤러
 * 
 * - 컨테이너 내에서 빈을 관리한다.
 * - 빈 : 컨트롤러, DAO, VO, DTO 등
 */

public class ActionFactory {
	public static ActionFactory instance = new ActionFactory();
	public static ActionFactory getInstance() {
		return instance;
	}
	public Action getAction(String command) {
		Action action = null;
		if(command.equals("index")) {
			action = new IndexAction();
		}else if(command.equals("join")) {
			action = new JoinAction();
		}else if(command.equals("idCheck")) {
			action = new IdCheckAction();
		}
//		else if(command.equals("login")) {
//			action = new LoginAction();
//		}
		
		
		return action;
		
	
	}

}
