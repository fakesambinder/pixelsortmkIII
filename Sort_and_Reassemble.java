package pixelsortmkII;

public class Sort_and_Reassemble {
	private Quicksort q = new Quicksort();
	private int[] n;
	private int[][] img;
	private int[][] origra;
	private int[][] sra;
	private int h;
	private int ht;
	private int hi;
	private int w;
	private int wt;
	private int wi;
	private int ixi;
	
	public Sort_and_Reassemble(int h, int w, int[][] img){
		this.h=h;
		ht = h;
		this.w=w;
		wt = w;
		this.img=img;
		origra = new int[h][w];
		for (int i = 0; i<h; i++){
		for (int j = 0; j<w; j++){
			origra[i][j] = img[i][j];
		}
		}
		hi=0;
		wi=0;
		ixi = 0;
	}
	
	public void setArray(int[] n){
		n= this.n;
		return;
	}
	public int[] getArray(){
		return n;
	}
	public int[][] noSort(){
		return img;
	}
	public int[][] vertSort(){
		n= new int[h];
		for(int g =wi; g<wt;g++){
		for(int i =hi; i<ht;i++){
			n[i]=img[i][g];
		}
		n=q.sort(n);
		for(int i =hi; i<ht;i++){
			img[i][g]=n[i];
		}
		}
		return noSort();
	}
	public int[][] horzSort(){
		n= new int[w];
		for(int g =hi; g<ht;g++){
			for(int i =wi; i<wt;i++){
				n[i]=img[g][i];
			}
			n=q.sort(n);
			for(int i =wi; i<wt;i++){
				img[g][i]=n[i];
			}
			}
			return noSort();
	}
	public int[][] hvSort(){
		horzSort();
		vertSort();
		return noSort();
	}
	public int[][] vhSort(){
		horzSort();
		vertSort();
		return noSort();
	}
	public int[][] longSortV(){
		n= new int[h*w];
		int idx = ixi;
		for(int g=hi; g<ht;g++){
		for(int i=wi; i<wt;i++){
			n[idx] = img[g][i];
			idx++;
		}
		}
		idx=0;
		n=q.sort(n);
		for(int g=hi; g<ht;g++){
		for(int i=wi; i<wt;i++){
			img[g][i] = n[idx];
			idx++;
		}
		}
		return noSort();
	}
	public int[][] longSortH(){
		n= new int[h*w];
		int idx = ixi;
		for(int g=hi; g<ht;g++){
		for(int i=wi; i<wt;i++){
			n[idx] = img[g][i];
			idx++;
		}
		}
		idx=ixi;
		n=q.sort(n);
		for(int g=wi; g<wt;g++){
		for(int i=hi; i<ht;i++){
			img[i][g] = n[idx];
			idx++;
		}
		}
		return noSort();
	}
	public int[][] n2sortH(){
		for(int f=0; f<wt; f++){
			vertSort();
			horzSort();
		}
		return noSort();
	}
	public int[][] n2sortV(){
		for(int f=0; f<ht; f++){
			horzSort();
			vertSort();
		
		}
		return noSort();
	}
	
	public int[][] adSort3(){
		//this doesn't work, don't use it.
		longSortH();
		f5origra();
		makesra(h, (w/3));
		wt = w/3;
		setupsra(hi,wi,ht,wt);
		int[][] temp = img;
		img = sra;
		
		longSortV();
		
		
		return noSort();
	}
	public int[][] adSort4(){
		//this doesn't work, don't use it.
		return noSort();
	}
	
	private void makesra(int hs, int ws){
		sra = new int[hs][ws];
		return;
	}
	private void setupsra(int hin, int win, int hen, int wen){
		for(int i = hin; i<hen; i++){
		for(int j = win; j<wen; j++){
			sra[i][j] = origra[i][j];
		}
		}
		return;
	}
	private void f5origra(){
		origra = new int[h][w];
		for (int i = 0; i<h; i++){
		for (int j = 0; j<w; j++){
			origra[i][j] = img[i][j];
		}
		}
		return;
		
	}
	
	
}
