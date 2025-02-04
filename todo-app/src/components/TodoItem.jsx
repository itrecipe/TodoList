const TodoItem = () => {
  return (
    <li className="todoItem">
      <div className="item">
        <input type="checkbox" id="test" />
        {/* htmlFor 속성은 반복문을 돌리기 위한 요소 */}
        <label htmlFor="test"></label>
        <span>할 일 내용1</span>
      </div>
      <div className="item">
        <button className="btn">삭제</button>
      </div>
    </li>
  );
};

export default TodoItem;
