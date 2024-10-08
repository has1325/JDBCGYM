package Gym.Logic.Logic;

import Gym.Logic.Common.Input;
import 민국.JDBCTrainerDao;
import 민국.LoginData;
import 민국.Trainer;
import 하성.Admin;
import 호영.Gym_Member;


public class LoginManager {
    private static LoginManager instance = null;

    private LoginManager(){
        init();
    }

    public static LoginManager getInstance()
    {
        if(instance == null)
            instance = new LoginManager();
        return instance;
    }

    private LoginData currentLoginUser;
    private Trainer tr = null;
    private Gym_Member gm = null;
    private Admin admin = null;

    private boolean isLogin = false;

    public void init()
    {
        currentLoginUser = new LoginData();
        isLogin = false;
    }


    public void selectLogin()
    {
        ShowManager.getInstance().showLoginMenu();

        int selectNum = Input.intScan(1,3);
        if (selectNum != 0)
        {
            switch(selectNum)
            {
                case 1:
                {
                    tryMemberLogin();
                    break;
                }
                case 2:
                {
                    tryTrainerLogin();
                    break;
                }
                case 3:
                {
                    tryManagerLogin();
                    break;
                }
            }
        }
    }

    public void tryMemberLogin()
    {
        System.out.println("아이디를 입력 해주세요");
        String id = Input.stringScan();
        System.out.println("비밀번호를 입력 해주세요");
        String pw = Input.stringScan();
    }

    public void tryTrainerLogin()
    {
        ShowManager.getInstance().showTrainerLogin();

        System.out.println("아이디를 입력 해주세요");
        String id = Input.stringScan();
        System.out.println("비밀번호를 입력 해주세요");
        String pw = Input.stringScan();

        //이 부분 trainer 객체로 바꿔야 함.
        LoginData login = new LoginData(id,pw, LoginData.MEMBERTYPE.TRAINER);
        Trainer curLoginTrainer = DAOManager.getInstance().gettDao().findByLoginData(id);

        if(tryLogin(login))
        {
            System.out.println("로그인 성공");
            tr = curLoginTrainer;
            isLogin = true;
        }
        else
        {
            System.out.println("로그인 실패");
        }
    }

    public void tryManagerLogin()
    {
        gm = DAOManager.getInstance().getmDao().findByMember_Num(1);
        isLogin = true;
        //임시로 넣어놓음,
        currentLoginUser = new LoginData(gm.getLogin_id(),gm.getLogin_pw(),LoginData.MEMBERTYPE.MEMBER);
    }

    public void tryLogin(LoginData.MEMBERTYPE type, String login_Id, String login_pw)
    {

    }

    public boolean tryLogin(LoginData loginData)
    {
        boolean result = false;
        JDBCTrainerDao tDao = DAOManager.getInstance().gettDao();
        if(tDao.tryLogin(loginData.getLogin_id(), loginData.getLogin_pw()))
        {
            System.out.println("로그인 성공");
            result = true;
        }
        else
        {
            System.out.println("로그인 실패");
            result = false;
        }

        return result;
    }

    public void setCurrentLoginUser(LoginData loginData)
    {
        currentLoginUser = loginData;
    }

    public void setCurrentLoginUser(LoginData.MEMBERTYPE type, String login_Id, String Login_Pw)
    {

    }

    public LoginData getCurrentLoginUser()
    {
        if(isLogin)
            return this.currentLoginUser;
        else
        {
            System.out.println("로그인 데이터가 없습니다.");
            return null;
        }
    }

    public void logOut()
    {
        currentLoginUser = null;
        isLogin = false;

        init();
    }

    public void tryJoin()
    {
        //회원 가입 - 트레이너와 멤버 구분 해서 가입하게 해야 함.
    }

    public Trainer getCurrentTrainer()
    {
        if (tr != null)
        {
            return tr;
        }
        else {

            System.out.println("트레이너 로그인 상태가 아닙니다.");
            return null;
        }
    }

    public Gym_Member getCurrentMember()
    {
        if(gm != null)
        {
            return gm;
        }
        else
        {
            System.out.println("멤버 로그인 상태가 아닙니다.");
            return null;
        }
    }

    //int a=0;

    public Admin getCurrentAdmin()
    {
        if(admin != null)
        {
            return admin;
        }
        else
        {
            System.out.println("관리자 로그인 상태가 아닙니다.");
            return null;
        }
    }


}
