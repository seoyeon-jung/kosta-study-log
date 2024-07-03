import axios from "axios";
import React, { useCallback, useEffect, useState } from "react";
import "./News.css";

const News = () => {
  const category_arr = [
    "business",
    "entertainment",
    "general",
    "health",
    "science",
    "sports",
    "technology",
  ];

  const [newsList, setNewsList] = useState(false);
  const [isLoading, setIsLoading] = useState(true);
  const [category, setCategory] = useState("business");

  const getNews = useCallback(async () => {
    try {
      const res = await axios.get(
        `https://newsapi.org/v2/top-headlines?country=kr&category=${category}&apiKey=${process.env.REACT_APP_API_KEY}`
      );
      //console.log(res.data.articles);
      const articles = res.data.articles;
      setNewsList(articles);
      setIsLoading(false);
    } catch (error) {
      console.error(error);
    }
  }, [category]);

  const handleCategory = (e) => {
    //console.log(e.target.innerText);
    setCategory(e.target.innerText);
  };

  useEffect(() => {
    // category가 변경될 때마다 실행
    getNews();
  }, [getNews]);

  if (isLoading) {
    return <div>loading...</div>;
  }

  return (
    <div className="news-list">
      {category_arr.map((category, idx) => {
        return (
          <button key={idx} className="category-btn" onClick={handleCategory}>
            {category}
          </button>
        );
      })}
      {newsList.map((article, idx) => {
        return (
          <div key={idx} className="news-item">
            <div className="thumbnail">
              <img src={article.urlToImage} alt={article.title} />
            </div>
            <div className="contents">
              <h2>{article.title}</h2>
              <p>{article.description}</p>
            </div>
          </div>
        );
      })}
    </div>
  );
};

export default News;
