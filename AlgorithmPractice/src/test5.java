import java.util.*;
class Person {
    String languege;
    String direct;
    String carior;
    String soulFood;
    int score;
}
class test5 {
    public static int[] solution(String[] info, String[] query) {
    	  int[] answer = new int[query.length];
          List<Person> list = new ArrayList<>();
          for(int i=0;i<info.length;++i){
              Person p = new Person();
              p.languege = info[i].split(" ")[0];
              p.direct =info[i].split(" ")[1];
              p.carior =info[i].split(" ")[2];
              p.soulFood =info[i].split(" ")[3];
              p.score =Integer.parseInt(info[i].split(" ")[4]);
              list.add(p);
          }
          for(int i=0;i<query.length;++i){
              int sum = 0;
              
              for(int j =0;j<list.size();++j){
                  Person p = list.get(j);
                  String languege = p.languege;
                  String direct =p.direct;
                  String carior = p.carior;
                  String soulFood = p.soulFood;
                  int score =p.score;
                  String[] where = query[i].split(" and ");
                  String last=where[3].split(" ")[0];
                  int num=Integer.parseInt(where[3].split(" ")[1]);
                  if(!where[0].equals("-")){
                      if(!where[0].equals(languege)){
                          continue;
                      }
                  }
                  if(!where[1].equals("-")){
                      if(!where[1].equals(direct)){
                          continue;
                      }
                  }
                  if(!where[2].equals("-")){
                      if(!where[2].equals(carior)){
                          continue;
                      }
                  }
                  if(!last.equals("-")){
                      if(!last.equals(soulFood)){
                          continue;
                      }
                  }
                  if(score < num){
                      continue;
                  }
                  sum++;
              }   
              answer[i]=sum;
          }
          return answer;
    }
    public static void main(String[] args) {
    	String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
    	String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
    	int[] arr = solution(info,query);
    	
    }
}