public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> content;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.content = new Stack<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            this.content.push(nestedList.get(i));
        } 
    }

    @Override
    public Integer next() {
        return content.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!content.isEmpty()) {
            NestedInteger curNested = content.peek();
            if (curNested.isInteger()) {
                return true;
            }
            content.pop();

            // curNested.getList().get(i);
            for (int i = curNested.getList().size() - 1; i >= 0; i--) {
                content.push(curNested.getList().get(i));
            }
        }
        return false;
    }
}

