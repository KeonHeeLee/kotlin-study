package module

import java.awt.Button

// is연산자는 자바의 instanceof를 대체한다.
// 그리고 is의 경우 그 객체가 맞는지 확인을 하기 때문에
// 테스트용으로 쓰면 유용할 것 같다.
fun printTypeName(obj: Any){
    if (obj is Int)
        println("Type is Integer")
    else if(obj is Float)
        println("Type is Float")
    else if(obj is String)
        println("Type is String")
    else
        println("Unknown Type")
}

fun kotlinBase04(){
    // 자료/자료형의 확인 및 변환
    // ==과 === 연산자
    val a: Pair<Char, Int> = Pair('A', 65)
    val b = a
    val c: Pair<Char, Int> = Pair('A', 65)

    // 값(value)의 동일성 체크
    if(b == c)
        println("b and c is equal!(value)")
    else
        println("b and c is not equal!(value)")

    // 객체의 동일성 체크
    if(a === b)
        println("a and b is equal!(entity)")
    else
        println("a and b is not equal!(entity)")

    if(a === c)
        println("a and c is equal!(entity)")
    else
        // 같은 객체가 아니므로 false를 반환하게 된다.
        println("a and c is not equal!(entity)")

    printTypeName(Int)
    printTypeName(b)

    // as 연산자
    // 자바의 캐스팅과 비슷한 유형이다.
    // java:: btn = (Button)findViewById(R.id.btn);
    val btn:Button = findViewById(R.id.btn) as Button

    // 스마트 캐스트 예제
    /* Java Example
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position){
        if(holder instanceof PhotoHolder){
            // PhotoHolder인 경우에만
            // 아래 메서드를 실행하지만,
            // PhotoHolder 내의 메서드를 호출하기 위해
            // 다시 캐스팅이 필요합니다.
            ((PhotoHolder) holder).setImageUrl(mImageUrl);
        } else if(holder instanceof TextHolder) {
            ((TextHolder) holder).setText(mTitles[position]);
        }
    } */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int){
        if(holder is PhotoHolder) holder.setImageUrl(mImageUrl)
        else if(holder is TextHolder) holder.setText(mTitles[position])
    }
}