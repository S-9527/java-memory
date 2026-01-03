import com.study.decorator.HistorySet;

void main() {
    HistorySet<String> set = new HistorySet<>();
    set.add("1");
    set.add("2");
    set.add("3");
    set.add("4");
    set.remove("4");
    set.remove("4");
    set.remove("5");
    set.remove("1");
    System.out.println(set);
}
