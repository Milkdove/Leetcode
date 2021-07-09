package leetcode;

import java.util.LinkedList;
import java.util.List;

class ThroneInheritance {
    public String kingName;
    public List<People> people = new LinkedList<>();
    public List<String> curOrder = new LinkedList<>();

    public ThroneInheritance(String kingName) {
        people.add(new People(kingName));
        this.kingName = kingName;
        curOrder.add(kingName);
    }

    public void birth(String parentName, String childName) {
        for (People p : people) {
            if (p.name.equals(parentName)) {
                People child = new People(childName);
                child.parent = p;
                p.childs.add(child);
                curOrder.add(Successor(child, curOrder).name);
                break;
            }
        }
    }

    public void death(String name) {
        for (People p : people) {
            if (p.name.equals(name)) {
                p.death();
                break;
            }
        }

    }

    public int check(List<People> p, List<String> curOrder) {
        for (People p1 : p) {
            if (!curOrder.contains(p1.name)) {
                return p.indexOf(p1);
            }
        }
        return -1;
    }

    public People Successor(People parent, List<String> curOrder) {

        if (parent.childs == null || check(parent.childs, curOrder) == -1) {
            if (parent.name.equals(this.kingName)) {
                return null;
            } else {
                return Successor(parent.parent, curOrder);
            }
        } else {
            return parent.childs.get(check(parent.childs, curOrder));
        }

    }

    public List<String> getInheritanceOrder() {
        for (People p : people) {
            if (!p.isAlive) {
                curOrder.remove(p.name);
            }
        }
        return curOrder;
    }

    public class People {
        public String name;
        public People parent;
        public List<People> childs = new LinkedList<>();
        public boolean isAlive = true;


        public People(String name) {
            this.name = name;
        }

        public void death() {
            this.isAlive = false;
        }
    }
}

/**
 * Your leetcode.ThroneInheritance object will be instantiated and called as such:
 * leetcode.ThroneInheritance obj = new leetcode.ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */