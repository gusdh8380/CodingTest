package hw2_tree;
// (1) 정수 키값을 저장할 공백 이진검색트리 tree를 생성
//(2) 사용자가 원하는 갯수의 정수 키값을 입력받아 tree에 삽입한 후, tree 출력
//(3) 정수 키값 x, y, z를 입력받아 각각 트리에 있는지 여부를 출력
//(4) tree의 최대 키값을 삭제하고, tree 출력
//(5) tree에서 앞의 정수 키값 x, y, z를 삭제하고, tree 출력(키값이 없으면 삭제하지 않으면 됨)
import java.util.Scanner;

public class hw2_BSTtree {
	public static void main(String[] args) {

		// (1) 정수 키값을 저장할 공백 이진검색트리 tree를 생성
		MyBinarySearchTree tree = new MyBinarySearchTree();

		// (2) 사용자가 원하는 갯수의 정수 키값을 입력받아 tree에 삽입한 후, tree 출력
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for(int i = 0; i < n; i++) {
			tree.add(input.nextInt());
		}
		System.out.println(tree);

		// (3) 정수 키값 x, y, z를 입력받아 각각 트리에 있는지 여부를 출력
		int x = input.nextInt();
		int y = input.nextInt();
		int z = input.nextInt();
		System.out.println(tree.contains(x) + " " + tree.contains(y) + " " + tree.contains(z));
		// (4) tree의 최대 키값을 삭제하고, tree 출력
		tree.removeMax();
		System.out.println(tree);
		// (5) tree에서 앞의 정수 키값 x, y, z를 삭제하고, tree 출력(키값이 없으면 삭제하지 않으면 됨) 
		tree.remove(x);
		tree.remove(y);
		tree.remove(z);
		System.out.println(tree);
		input.close();
	}
}

// 정수 키값을 갖는 이진검색트리를 구현하는 클래스
class MyBinarySearchTree {
	// 루트 노드를 가리키는 인스턴스 변수 root (알고리즘 연습을 위해 root 만 둘 것)
	private Node root;


	// 노드의 구조를 정의하는 클래스 Node (알고리즘 연습을 위해 노드에 key, left, right 필드만 둘 것)
	public class Node{
		int key;
		Node left;
		Node right;

	}

	// 키 값을 매개변수로 받아 그 키값이 존재하는지 여부(true/false)를 리턴
	public boolean contains(int key) {
		Node t =root; 
		while(t != null) {
			if(key == t.key)
				return true;
			else if(key < t.key)
				t = t.left;
			else 
				t = t.right;
		}
		return false;
	}

	// 매개변수로 받은 키값을 트리에 삽입
	public void add(int key) {
		root = treeInsert(root, key);
	}

	// t를 루트로 하는 트리에 key를 삽입하고, 삽입 후 루트 노드를 리턴하는 재귀 메소드
	private Node treeInsert(Node t, int key) {
		if(t == null) {
			Node r = new Node();
			r.key = key;
			return r;
		}
		else if(key < t.key) {
			t.left = treeInsert(t.left, key);
			return t;
		}
		else if(key > t.key) {
			t.right = treeInsert(t.right, key);
			return t;
		}
		else {
			return t;  // 이미 존재하는 키값인 경우 삽입하지 않음
		}

	}
	//트리삭제메소드 treeDelete 구현 - 강의노트 참조 / removeMax(),remove() 메소드 보조 메소드
	private Node treeDelete(Node r,Node t,Node p) { 
		r= root;									//r을 루트노드라 하고
		if(t == r)									//만일 삭제할 노드 t가 r과 같다면
			return root = deleteNode(r);			// root 삭제, deleteNode메소드 case3으로
		else if(t == p.left) {						//만일 삭제할 노드 t가 t의 부모노드p의 왼쪽자식이라면
			return p.left = deleteNode(t);			//p의 왼쪽자식 삭제
		}else 										// 위와 동일
			return p.right = deleteNode(t);
	}	
	//노드삭제메소드 deleteNode메소드 구현- 강의노트 참조
	private Node deleteNode(Node t) {							//삭제할 노드 t
		if(t.left==null && t.right==null) {//만일 t의 왼쪽,오른쪽 자식이 없다면
			return null;										//null 리턴, 즉 t만 제거
		}else if(t.left==null&&t.right !=null) {				//t가 왼쪽자식만 있다면
			return t.right;										//t가 삭제되고오른쪽 자식이 대신 올라와 붙음
		}else if(t.left!=null&&t.right ==null) {				//t가 오른쪽자식만 있다면
			return t.left;										//t가 삭제되고 왼쪽자식이 올라옴 
		}else {													//***자식이 양쪽에 다있으면
			Node s = t.right;				//s는 t의 오른쪽 자식(트리의 루트노드)이라고 저장
			Node p = s;						//p(s)는 즉 t의 부모노드
			while(s.left != null) {			//r의 서브트리중에서 최소인 s 찾기		
				p = s;						//s의 left가 null이 아닐떄까지 : 루트노드가 s인 트리에서의 최소값 찾기
				s = s.left;					//즉 t를 대신할 직후원소 찾기

			}
			t.key = s.key;					//s의 내용을 t에 복사 후 s 삭제
			if(s == t.right)				
				return t.right =s.right;	
			else 
				p.left = s.right;

			return t;
		}
	}
	//removeMax 메소드 구현
	public void removeMax() {   //매개변수 없이 최대 키캆을 삭제, 트리의 최대값x를 찾은 후. x의 부모노드와 x의 자식노드(또는 null)를 연결
		Node t = root; 			
		while(t.right != null){			//최댓값을 가진 노드구하기	
			t = t.right;
		}
		Node s = FindParent(root,t);	//최대값 노드의 부모노드구하기 -> 삭제메소드 사용하기위해서
		treeDelete(root,t,s); // 최대값이면 삭제 진행, treeDelete메소드 사용
		return;

	}



	//remove 메소드 구현 : 키 값을 파라미터로 받아서 삭제 
	public void remove(int key) { //키 값을 받았으니 삭제메소드의 파라미터는 루트노드, 삭제할 노드, 부모노드이니 삭제할 키의 부모와 노드ID를 구해주자
		if(contains(key)==false) {			//키값이 없으면 출력하지 않아도 되게금하는 코드
			return;							//이 코드 없으면 "Cannot read field "left" because "p" is null"오류가 발생한다....
		}else if(contains(key) == true) {	
			Node r =treeSearch(root,key); //삭제할 노드 찾기
			Node p =FindParent(root,r);	//삭제할 노드의 부모노드찾기
			Node t = root;
			treeDelete(t,r,p);
		}
	}
	//부모노드를 구하는 메소드 -> 삭제메소드의 파라미터 사용 때문에 구현
	private Node FindParent(Node t,Node r) {	
		if (t == null|| t == r) {				//만일 루트노르라면 null 리턴
			return null;
		}

		if (t.left == r || t.right == r) {		//현재위차한 노드 t의양쪽 자식들 중 구하고자하는 노드r과 같다 -> 찾고자하는 부모노드 
			return t;
		}
		Node L = t.left;						// 왼쪽 서브트리에서 찾기 -> 재귀호출로
		Node p = FindParent(L, r);				//위에 둘 조건에 없다면 서브트리로 간다/p에 재귀호출로 왼쪽 서브트리 부터 검사해서
		if (p != null) {						//p가 null이 아니다 = 왼쪽서브트리에서 부모를 찾았다
			return p;							//그럼 p를 리턴
		}else {
			Node R = t.right;					//오른쪽 서브트리에서도 찾기 -> 재귀호출 / 굳이조건문은 필요x 재귀호출하니까
			return FindParent(R, r);
		}
	}
	//검색 메소드 구현_강의노트 참조
	private Node treeSearch(Node t, int key) {		

		if(t ==null || t.key ==key)				//찾는 키가 루트노드다
			return t;
		if(key < t.key) {						//찾는 키가 왼쪽 서브트리에 있다
			return treeSearch(t.left,key);		//왼쪽 서브트리를 재귀호출로 검색
		}else return treeSearch(t.right,key);	//오른쪽이다/ 위와동일


	}

	// 트리의 키값들을 중순위 순회하여 오름차순으로 나열한 하나의 문자열을 만들어 리턴
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer("tree = ");
		if(root != null) {
			inorder(result, root);
		}
		return result.toString();
	}

	// t를 루트로 하는 트리를 중순위 순회
	private void inorder(StringBuffer result, Node t) {
		if(t != null) {
			inorder(result, t.left);
			result.append(t.key + " ");
			inorder(result, t.right);
		}
	}
}
