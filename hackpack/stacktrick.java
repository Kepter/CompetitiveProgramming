public static void main(String args[]){
		new Thread(null, () ->main2(args), "tricked", 1<<28).start();
}

public static void main2(String[] args) {
}