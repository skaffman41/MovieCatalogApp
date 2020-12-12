package ru.alexnimas.sources.base.core.adapter

//class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
//    /**
//     * Слушатель нажатия на элемент списка
//     */
//    private var onItemClickListener: OnItemClickListener? = null
//
//    private val movies: MutableList<Movie> = mutableListOf()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view =
//            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return movies.size
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val movie = movies[position]
//        holder.itemView.setOnClickListener {
//            onItemClickListener?.onItemClick(position, movie)
//        }
//        holder.bind(movie)
//    }
//
//    fun setData(movies: List<Movie>) {
//        this.movies.clear()
//        this.movies.addAll(movies)
//        notifyDataSetChanged()
//    }
//
//    /**
//     * Установка слушателя нажатий на элемент
//     */
//    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
//        this.onItemClickListener = onItemClickListener
//    }
//
//    /**
//     * Интерфейс слушателя нажатия на элемент
//     */
//    interface OnItemClickListener {
//
//        /**
//         * Действие на нажатие элемента
//         * @param position номер элемента в списке
//         * @param item элемент списка
//         */
//        fun onItemClick(position: Int, item: Movie)
//    }
//
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val movieImage: ImageView = itemView.findViewById(R.id.movie_image)
//        private val movieTitle: TextView = itemView.findViewById(R.id.movie_title)
//
//        fun bind(movie: Movie) {
//            Glide
//                .with(itemView)
//                .load("https://image.tmdb.org/t/p/w300${movie.posterPath}")
//                .into(movieImage)
//            movieTitle.text = movie.title ?: movie.originalName
//        }
//    }
//}