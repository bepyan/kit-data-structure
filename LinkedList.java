// List를 구성하는 Node 클래스
class ListNode {
    private String data; // 데이터 저장 변수
    public ListNode next; // 다른 노드를 참조할 링크 노드

    public ListNode(String data) {
        this.data = data;
        this.next = null;
    }

    public String getData() {
        return this.data;
    }
}

public class LinkedList {

    private ListNode head; // ListNode 타입의 head 노드 인스턴스 변수

    public LinkedList() {
        head = null;
    }

    public void insertNode(ListNode pre, String data) {
        ListNode newNode = new ListNode(data);
        newNode.next = pre.next;
        pre.next = newNode;
    }

    // 마지막 노드에 삽입
    public void insertNode(String data) {
        ListNode newNode = new ListNode(data);
        ListNode target = head;
        // head가 null인 경우 head.next를 접근할 수 없기 때문
        if (target == null) {
            this.head = newNode;
            return;
        }

        while (target.next != null)
            target = target.next;

        target.next = newNode;
    }

    // 맨앞에 노드에 삽입
    public void insertFront(String data) {
        ListNode newNode = new ListNode(data);
        newNode.next = this.head.next;
        this.head = newNode;

    }

    // data와 일치한 node 삭제
    public void deleteNode(String data) {
        ListNode target = head;
        // 첫 번째 노드를 삭제할 경우
        if (data.equals(target.getData())) {
            head = target.next;
            target.next = null;
            return;
        }

        ListNode pre = head;
        target = target.next;
        while (target != null) {
            if (data.equals(target.getData())) {
                // 마지막 노드를 삭제할 경우
                if (target.next == null)
                    pre.next = null;
                else {
                    pre.next = target.next;
                    target.next = null;
                }
                break;
            }
            pre = target;
            target = target.next;
        }
    }

    // Node 삭제(마지막 노드 삭제)
    public void deleteNode() {
        if (head == null)
            return;

        // 노드가 1개 남았을 경우
        if (head.next == null) {
            head = null;
            return;
        }

        ListNode preNode = head;
        ListNode target = head.next;
        while (target.next != null) {
            preNode = target;
            target = target.next;
        }
        target = null;
        preNode.next = null;
    }

    // Node 탐색
    public ListNode searchNode(String data) {
        for (ListNode tmp = this.head; tmp != null; tmp = tmp.next)
            if (data.equals(tmp.getData()))
                return tmp;

        return null;
    }

    // 리스트의 노드를 역순으로 구성
    public void reverseList() {
        ListNode nextNode = this.head;
        ListNode currentNode = null;
        ListNode preNode = null;

        while (nextNode != null) {
            preNode = currentNode;
            currentNode = nextNode;
            nextNode = nextNode.next;
            currentNode.next = preNode;
        }

        this.head = currentNode;
    }

    // 연결 리스트에 저장된 모든 데이터를 출력
    public void printList() {
        for (ListNode tmp = this.head; tmp != null; tmp = tmp.next) {
            System.out.print(tmp.getData() + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        LinkedList linkedList = new LinkedList();

        linkedList.insertNode("sun");
        linkedList.insertNode("mon");
        linkedList.insertNode("tue");
        linkedList.insertNode("wed");
        linkedList.insertNode("thu");
        linkedList.insertNode("fri");
        linkedList.insertNode("sat");
        linkedList.printList();

        System.out.println(linkedList.searchNode("wed").getData());

        linkedList.deleteNode(linkedList.searchNode("wed").getData());
        linkedList.printList();

        linkedList.deleteNode(linkedList.searchNode("sun").getData());
        linkedList.printList();

        linkedList.reverseList();
        linkedList.printList();
    }

}