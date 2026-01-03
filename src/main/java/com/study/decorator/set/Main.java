import com.study.decorator.set.HistorySet;

void main() {
    Set<String> historySet = new HistorySet<>(new HashSet<>());
    Set<String> set = new HistorySet<>(historySet);
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
