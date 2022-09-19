package hello.core.singleton;

public class SingletonService {

    //자기자신 호출
    private static final SingletonService instance = new SingletonService();

    //2. 객체 인스턴스가 필요 시 이 매소드를 통해 조회
    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {}

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }




}

