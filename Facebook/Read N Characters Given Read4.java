当遇到 eof，可能少于 n bytes

public int read(char[] buf, int n) {
  boolean eof = false;      // end of file flag
  int total = 0;            // total bytes have read
  char[] tmp = new char[4]; // temp buffer
  
  while (!eof && total < n) {
    
    // read4(tmp);
    int count = read4(tmp);
    
    // check if it's the end of the file
    eof = count < 4;
    
    // get the actual count
    count = Math.min(count, n - total);
   
    //Input:
    "ab"
    1
    Output:
    "ab"
    Expected:
    "a"
    // copy from temp buffer to buf
    for (int i = 0; i < count; i++) 
      buf[total++] = tmp[i];
  }
  
  return total;
}


Call multiple times

多次调用 read() 时可能会发生：之前一次调用中从 read4() 读取的字符未使用完（已经到达 n bytes)，
所以要将 buffer 设为全局变量，并记录其大小 buffersize 和上次读到的位置 offset，
当 buffer 为空 (buffersize == 0) 时才调用 read4()，并且每次从 buffer 的 offset 开始拷贝到 buff。


private int buffPtr = 0;
private int buffCnt = 0;
private char[] buff = new char[4];

public int read(char[] buf, int n) {
    int ptr = 0;

    while (ptr < n) {
        // buffPtr == 0 再调用read4(buff);
        if (buffPtr == 0) {
            buffCnt = read4(buff);
        }

        if (buffCnt == 0) break;

        while (ptr < n && buffPtr < buffCnt) {
            buf[ptr++] = buff[buffPtr++];
        }
        if (buffPtr >= buffCnt) buffPtr = 0;
    }

    return ptr;
}



