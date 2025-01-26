#include <queue>
using namespace std;

class MyStack {
private:
    queue<int> queue1, queue2;

public:
    MyStack() {}

    void push(int x) {
        queue1.push(x);
    }

    int pop() {
        while (queue1.size() > 1) {
            queue2.push(queue1.front());
            queue1.pop();
        }
        int topElement = queue1.front();
        queue1.pop();
        swap(queue1, queue2);
        return topElement;
    }

    int top() {
        while (queue1.size() > 1) {
            queue2.push(queue1.front());
            queue1.pop();
        }
        int topElement = queue1.front();
        queue2.push(queue1.front());
        queue1.pop();
        swap(queue1, queue2);
        return topElement;
    }

    bool empty() {
        return queue1.empty();
    }
};