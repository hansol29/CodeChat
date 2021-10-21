package com.codeChat.controller;

import com.codeChat.controller.action.Action;
import com.codeChat.controller.action.BoardDeleteAction;
import com.codeChat.controller.action.BoardListAction;
import com.codeChat.controller.action.BoardListAction2;
import com.codeChat.controller.action.BoardOneAction;
import com.codeChat.controller.action.BoardReplyAction;
import com.codeChat.controller.action.BoardReplyDeleteAction;
import com.codeChat.controller.action.BoardReplyViewAction;
import com.codeChat.controller.action.BoardSearchAction;
import com.codeChat.controller.action.BoardUpdateAction;
import com.codeChat.controller.action.BoardUpdateFormAction;
import com.codeChat.controller.action.BoardWriteAction;
import com.codeChat.controller.action.BoardWriteFormAction;
import com.codeChat.controller.action.CompanyBoardAction;
import com.codeChat.controller.action.CompanyBoardListAction;
import com.codeChat.controller.action.CompanyContractAction;
import com.codeChat.controller.action.CompanyIdCheckFormAction;
import com.codeChat.controller.action.CompanyJoinAction;
import com.codeChat.controller.action.CompanyJoinFormAction;
import com.codeChat.controller.action.CompanyLoginAction;
import com.codeChat.controller.action.CompanyLoginFormAction;
import com.codeChat.controller.action.CompanyMypageAction;
import com.codeChat.controller.action.DeleteCompanyBoard;
import com.codeChat.controller.action.DeleteMyWriteAction;
import com.codeChat.controller.action.IndexAction;
import com.codeChat.controller.action.InsertCompanyBoardAction;
import com.codeChat.controller.action.InsertCompanyBoardFormAction;
import com.codeChat.controller.action.LogoutAction;
import com.codeChat.controller.action.MyVideoAction;
import com.codeChat.controller.action.MyWriteAction;
import com.codeChat.controller.action.PayFailAction;
import com.codeChat.controller.action.PaySuccessAction;
import com.codeChat.controller.action.QnaDeleteAction;
import com.codeChat.controller.action.QnaListAction;
import com.codeChat.controller.action.QnaOneAction;
import com.codeChat.controller.action.QnaReplyAction;
import com.codeChat.controller.action.QnaReplyViewAction;
import com.codeChat.controller.action.QnaWriteAction;
import com.codeChat.controller.action.QnaWriteFormAction;
import com.codeChat.controller.action.RemoveUserAction;
import com.codeChat.controller.action.SelectAction;
import com.codeChat.controller.action.UpdateComBoardFormAction;
import com.codeChat.controller.action.UpdateCompanyBoard;
import com.codeChat.controller.action.UpdateCompanyMypageAction;
import com.codeChat.controller.action.UpdateCompanyMypageAction2;
import com.codeChat.controller.action.UpdateUserMypageAction;
import com.codeChat.controller.action.UpdateUserMypageAction2;
import com.codeChat.controller.action.UserContractAction;
import com.codeChat.controller.action.UserIdCheckFormAction;
import com.codeChat.controller.action.UserJoinAction;
import com.codeChat.controller.action.UserJoinFormAction;
import com.codeChat.controller.action.UserLoginAction;
import com.codeChat.controller.action.UserLoginFormAction;
import com.codeChat.controller.action.UserMypageAction;
import com.codeChat.controller.action.mainAction;

public class ActionFactory {

	private ActionFactory() {
	}

	private static ActionFactory instance = new ActionFactory();

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {

		Action action = null;
		System.out.println("여기는 ActionFactory; [command = " + command + "]");
		// 김령규
		if (command.equals("index")) {
			action = new IndexAction();
		}else if (command.equals("payFail")) {
			action = new PayFailAction();
		}else if (command.equals("paySuccess")) {
			action = new PaySuccessAction();
		}else if (command.equals("myVideo")) {
			action = new MyVideoAction();
		}
		
		//고수정
		if (command.equals("login_form")) {
			action = new UserLoginFormAction();
		} else if (command.equals("login")) {
			action = new UserLoginAction();
		} else if (command.equals("admin_login_form")) {
			action = new CompanyLoginFormAction();
		} else if (command.equals("admin_login")) {
			action = new CompanyLoginAction();
		} else if (command.equals("usercontract")) {
			action = new UserContractAction();
		} else if (command.equals("companycontract")) {
			action = new CompanyContractAction();
		} else if (command.equals("join_form")) {
			action = new UserJoinFormAction();
		} else if (command.equals("admin_join_form")) {
			action = new CompanyJoinFormAction();
		} else if (command.equals("join")) {
			action = new UserJoinAction();
		} else if (command.equals("admin_join")) {
			action = new CompanyJoinAction();
		} else if (command.equals("id_check_form")) {
			action = new UserIdCheckFormAction();
		} else if (command.equals("admin_id_check_form")) {
			action = new CompanyIdCheckFormAction();
		} else if (command.equals("mypage")) {
			action = new UserMypageAction();
		} else if (command.equals("updateuser")) {
			action = new UpdateUserMypageAction();
		} else if (command.equals("admin_mypage")) {
			action = new CompanyMypageAction();
		} else if (command.equals("logout")) {
			action = new LogoutAction();
		} else if (command.equals("updateuser2")){
			action = new UpdateUserMypageAction2();
		} else if (command.equals("removeUser")) {
			action = new RemoveUserAction();
		} else if (command.equals("updatecompany2")) {
			action = new UpdateCompanyMypageAction2();
		} else if (command.equals("updatecompany")) {
			action = new UpdateCompanyMypageAction();
		}
		
		// 김한솔
		if(command.equals("board_list")) {
			action = new BoardListAction(); 
		}else if(command.equals("board_write_form")) {
			action = new BoardWriteFormAction();
		}else if(command.equals("board_write")) {
			action = new BoardWriteAction();
		}else if(command.equals("board_one")) {
			action = new BoardOneAction();
		}else if(command.equals("board_update_form")) {
			action = new BoardUpdateFormAction();
		}else if(command.equals("board_update")) {
			action = new BoardUpdateAction();
		}else if(command.equals("board_delete")) {
			action = new BoardDeleteAction();
		}else if(command.equals("board_list_cnt")) {
			action = new BoardListAction2();
		}	else if (command.equals("board_search")) {
			action = new BoardSearchAction();
		} else if (command.equals("board_reply_view")) {
			action = new BoardReplyViewAction();
		} else if (command.equals("board_reply")) {
			action = new BoardReplyAction();
		} else if(command.equals("board_reply_delete")){
			action = new BoardReplyDeleteAction();
		}	else if (command.equals("logout")) {		
			action = new LogoutAction();
		} else if (command.equals("qna_list")) {
			action = new QnaListAction();
		} else if (command.equals("qna_write_form")) {
			action = new QnaWriteFormAction();
		} else if (command.equals("qna_write")) {
			action = new QnaWriteAction();
		} else if (command.equals("qna_one")) {
			action = new QnaOneAction();
		} else if (command.equals("qna_reply_view")) {
			action = new QnaReplyViewAction();
		} else if (command.equals("qna_reply")) {
			action = new QnaReplyAction();
		} else if (command.equals("qna_delete")) {
			action = new QnaDeleteAction();
		} else if (command.equals("myWrite")) {
			action = new MyWriteAction();
		} else if (command.equals("delete_myWrite")) {
			action = new DeleteMyWriteAction();
		}
		
		// 김은수
		if (command.equals("comBoardList")) {
			action = new CompanyBoardListAction();
		} else if (command.equals("comBoard")) {
			action = new CompanyBoardAction();
		} else if (command.equals("updateComBoardForm")) {
			action = new UpdateComBoardFormAction();
		} else if (command.equals("updateComBoard")) {
			action = new UpdateCompanyBoard();
		} else if (command.equals("deleteComBoard")) {
			action = new DeleteCompanyBoard();
		} else if (command.equals("insertComBoardForm")) {
			action = new InsertCompanyBoardFormAction();
		} else if (command.equals("insertComBoard")) {
			action = new InsertCompanyBoardAction();
		} else if (command.equals("select")) {
			action = new SelectAction();
		} else if (command.equals("main")) {
			action = new mainAction();
		}
	

		return action;
	}
}
