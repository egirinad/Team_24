package at.tugraz.ist.guessingwords.ui.custom_words.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import at.tugraz.ist.guessingwords.R
import at.tugraz.ist.guessingwords.data.entity.Word

class CustomWordsAdapter(val context: Context, val customWords: List<Word>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(
        Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = inflater.inflate(R.layout.list_item_custom_words, parent, false)

            viewHolder = ViewHolder()
//            viewHolder.tvCustomWordNumber = view.findViewById<TextView>(R.id.li_customWord_number)
            viewHolder.tvCustomWordText = view.findViewById<TextView>(R.id.li_customWord_text)
//            viewHolder.tvCustomWordAmount = view.findViewById<TextView>(R.id.tv_count_words)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = convertView.tag as ViewHolder
        }

        val customWord = getItem(position) as Word

//        viewHolder.tvCustomWordNumber.text = "#${position + 1}: "
//        var string = customWords.size.toString() + " Words"
//        viewHolder.tvCustomWordAmount.text = string
        viewHolder.tvCustomWordText.text = customWord.text

        return view
    }

    override fun getItem(position: Int): Any {
        return customWords[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return customWords.size
    }

    private class ViewHolder {
//        lateinit var tvCustomWordNumber : TextView
        lateinit var tvCustomWordText : TextView
//        lateinit var tvCustomWordAmount : TextView
    }

}